<%@include file="assets/header.jsp"%>

<div class="container w-25 vh-100 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow bg-body rounded ">
        <h2>Please enter your name</h2>
        <form action="quiz">
            <label for="name">Name: </label>
        <input type="text" id="name" class="form-control" name="name">

        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">Start Quiz!!</button>
        </div>
        </form>
    </div>
</div>

<%@include file="assets/footer.jsp"%>
