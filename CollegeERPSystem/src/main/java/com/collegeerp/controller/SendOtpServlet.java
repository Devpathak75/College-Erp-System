package com.collegeerp.controller;

import java.io.IOException;
import java.sql.*;
import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.collegeerp.dao.DBConnection;
import com.collegeerp.util.EmailUtil;

@WebServlet("/sendOtp")
public class SendOtpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(true);

        // 🔥 ROLE FIX: session first, request fallback
        String role = (String) session.getAttribute("role");
        if (role == null) {
            role = request.getParameter("role");
            session.setAttribute("role", role);
        }

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String email = null;

            // =======================
            // STUDENT LOGIN + OTP
            // =======================
            if ("student".equals(role)) {

                String enrollment = request.getParameter("enrollment");
                String password   = request.getParameter("password");

                con = DBConnection.getConnection();
                ps = con.prepareStatement(
                    "SELECT id, name, email, password, year, department_id " +
                    "FROM student WHERE enrollment=?"
                );
                ps.setString(1, enrollment);
                rs = ps.executeQuery();

                if (!rs.next()) {
                    response.sendRedirect("login.jsp?type=student&error=Enrollment not found");
                    return;
                }

                if (!rs.getString("password").equals(password)) {
                    response.sendRedirect("login.jsp?type=student&error=Wrong password");
                    return;
                }

                email = rs.getString("email");

                session.setAttribute("studentId", rs.getInt("id"));
                session.setAttribute("studentName", rs.getString("name"));
                session.setAttribute("departmentId", rs.getInt("department_id"));
                session.setAttribute("year", rs.getInt("year"));
                session.setAttribute("email", email);
            }

            // =======================
            // ADMIN OTP ONLY
            // =======================
            else if ("admin".equals(role)) {

                email = (String) session.getAttribute("email");

                if (email == null) {
                    response.sendRedirect("login.jsp?type=admin&error=sessionExpired");
                    return;
                }
            }

            // =======================
            // FACULTY OTP ONLY
            // =======================
            else if ("faculty".equals(role)) {

                email = (String) session.getAttribute("email");

                if (email == null) {
                    response.sendRedirect("login.jsp?type=faculty&error=sessionExpired");
                    return;
                }
            }

            else {
                response.sendRedirect("login.jsp?error=InvalidRole");
                return;
            }

            // =======================
            // OTP GENERATION
            // =======================
            int otp = new Random().nextInt(900000) + 100000;

            session.setAttribute("otp", otp);
            session.setAttribute("otpTime", System.currentTimeMillis());

            EmailUtil.sendMail(email, otp);

            response.sendRedirect("verifyOtp.jsp?sent=1");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=ServerError");
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            try { if (con != null) con.close(); } catch (Exception ignored) {}
        }
    }
}