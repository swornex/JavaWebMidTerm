<%@ include file="templates/header.jsp" %>

<div class="container w-25 vh-100 d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow bg-body rounded ">
<%--        bg-success p-2 text-white bg-opacity-75--%>
        <form action="login" method="post">
            <h2 class="text-center"> Sign In Here </h2>
            <div class="my-3">
                <label for="username" class="form-label">Username: </label>
                <input type="text" class="form-control" id="username" name="username" value="${username}">
            </div>
            <div class="my-3">
                <label for="password" class="form-label">Password: </label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <p class="text-danger">${error!=null ? error : ""}</p>
            <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="templates/footer.jsp" %>
