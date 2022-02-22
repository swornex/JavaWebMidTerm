<%@include file="assets/header.jsp"%>

<div class="container w-75 vh-100 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow bg-body rounded ">
        <h2>Hello guest!!</h2>
        <h4>Attempt all the question!!!</h4>
        <form>
            <div my-5 container p-3>
            <h5>What is your name?</h5>
            <input type="radio" name="quetionOne" value="Swornima">
            <input type="radio" name="quetionOne" value="Aayush">
            <input type="radio" name="quetionOne" value="Sabin">
            <input type="radio" name="quetionOne" value="Sagar">
            </div>
            <div my-5 container p-3>
                <h5>What is your age?</h5>
                <input type="radio" name="quetiontwo" value="21">
                <input type="radio" name="quetiontwo" value="15">
                <input type="radio" name="quetiontwo" value="23">
                <input type="radio" name="quetiontwo" value="20">
            </div>
            <div class="d-flex justify-content-right">
                <button type="submit" class="btn btn-primary">Start Quiz!!</button>
            </div>
        </form>

    </div>
</div>

<%@include file="assets/footer.jsp" %>
