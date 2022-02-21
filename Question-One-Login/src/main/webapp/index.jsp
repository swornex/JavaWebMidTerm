<%@ include file="templates/header.jsp" %>

<c:if test="${user == null}">
    <c:redirect url="login"/>
</c:if>

<div class="container w-25 vh-100 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow bg-body rounded ">
        <h2>Hello ${user.first_name} ${user.last_name}!</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
            dolore
            magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
            commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
            pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id
            est
            laborum.</p>
        <div class="d-flex justify-content-center">
            <a href="logout" class="btn btn-primary">Logout</a>
        </div>
    </div>
</div>

<%@ include file="templates/footer.jsp" %>
