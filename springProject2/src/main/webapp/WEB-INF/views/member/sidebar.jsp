<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="smembership" value='<%=session.getAttribute("smembership")%>' />

<aside class="sticky-top" style="position: sticky; top: 2rem; float: left; z-index: auto;">
    <ul class="list-group" style="width: fit-content;">
        <li class="list-group-item active" aria-current="true">Profile</li>
        <li class="list-group-item">A third item</li>
        <li class="list-group-item">A fourth item</li>
        <li class="list-group-item">And a fifth one</li>
    </ul>
</aside>