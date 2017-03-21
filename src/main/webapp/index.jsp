<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Hi 
<shiro:guest>Guest</shiro:guest>
<shiro:user>
<%
    //This should never be done in a normal page and should exist in a proper MVC controller of some sort, but for this
    //tutorial, we'll just pull out Stormpath Account data from Shiro's PrincipalCollection to reference in the
    //<c:out/> tag next:

    request.setAttribute("account", org.apache.shiro.SecurityUtils.getSubject().getPrincipals().oneByType(java.util.Map.class));

%>
<c:out value="${account.givenName}"/></shiro:user>!
    ( <shiro:user><a href="<c:url value="/logout"/>">Log out</a></shiro:user>
    <shiro:guest><a href="<c:url value="/login"/>">Log in</a></shiro:guest> )
</p>

<shiro:authenticated><p>Visit your <a href="<c:url value="/home"/>">home page</a>.</p></shiro:authenticated>
<shiro:notAuthenticated><p>If you want to access the authenticated-only <a href="<c:url value="home"/>">home page</a>,
    you will need to log-in first.</p></shiro:notAuthenticated>
    
    
    <h2>Roles</h2>

<p>Here are the roles you have and don't have. Log out and log back in under different user
    accounts to see different roles.</p>

<h3>Roles you have:</h3>

<p>
    <shiro:hasRole name="Captains">Captains<br/></shiro:hasRole>
    <shiro:hasRole name="Officers">Bad Guys<br/></shiro:hasRole>
    <shiro:hasRole name="Enlisted">Enlisted<br/></shiro:hasRole>
</p>

<h3>Roles you DON'T have:</h3>

<p>
    <shiro:lacksRole name="Captains">Captains<br/></shiro:lacksRole>
    <shiro:lacksRole name="Officers">Officers<br/></shiro:lacksRole>
    <shiro:lacksRole name="Enlisted">Enlisted<br/></shiro:lacksRole>
</p>