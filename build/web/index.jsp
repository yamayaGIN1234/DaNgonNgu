<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Internationalization Example</title>
    </head>
    <body>
        <h2><%= request.getAttribute("greeting") %></h2>
        
        <form action="LangServlet" method="get">
            <label><%= request.getAttribute("language") %>:</label>
            <select name="lang" onchange="this.form.submit()">
                <option value="en" <%= "en".equals(request.getParameter("lang")) ? "selected" : "" %>>English</option>
                <option value="vi" <%= "vi".equals(request.getParameter("lang")) ? "selected" : "" %>>Tiếng Việt</option>
            </select>
        </form>
    </body>
</html>
