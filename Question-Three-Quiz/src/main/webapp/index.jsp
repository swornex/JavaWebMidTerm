<%@include file="templates/header.jsp" %>

<div class="container w-50 vh-100 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow bg-body rounded ">
        <h2>Welcome!!! <br/> Please enter your name :)</h2>
        <form action="quiz">
            <div class="mb-3">
                <label for="name">Name: </label>
                <input type="text" id="name" class="form-control" name="name">
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">Start Quiz!!</button>
            </div>
        </form>
    </div>
</div>

<%@include file="templates/footer.jsp" %>
