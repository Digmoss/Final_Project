<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Combined JSP Application</title>
</head>
<body>
    <h2>Enter Your Name</h2>
    <form action="Project.jsp" method="post">
        <input type="text" name="username" placeholder="Enter your name here" required>
        <input type="submit" name="action" value="Submit Name">
        <input type="submit" name="action" value="Say Hello">
    </form>
    <%
        String name = request.getParameter("username");
        String action = request.getParameter("action");
        if (name != null && !name.isEmpty()) {
            if ("Say Hello".equals(action)) {
                out.println("<h3>Hello, " + name + "!</h3>");
            } else if ("Submit Name".equals(action)) {
                out.println("<h3>Name submitted: " + name + "</h3>");
            }
        }
    %>
</body>
</html>