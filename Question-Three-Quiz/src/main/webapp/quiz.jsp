<%@include file="templates/header.jsp"%>

<div class="container w-75 jumbotron d-flex">
    <div class="mb-auto mt-auto w-100 p-5 shadow bg-body rounded ">
        <div class="d-flex justify-content-center">
        <h2 >Hello ${name}!!</h2>
        </div>
        <h4>Score: ${score}</h4>
        <h5>Attempt all the question!!!</h5>
        <form action="quiz" method="post">
            <div my-5 container p-3>
             <c:forEach var="quiz" items="${quizzes}" varStatus="loop">
                <div class="my-5 container p-3 shadow-sm rounded" id="${quiz.id}">
                    <p><b>${loop.count}. ${quiz.question}</b></p>
                    <c:if test="${score==0}">
                    <div class="answers m-3 mb-0 d-flex flex-row align-items-center justify-content-between w-75 mx-auto">
                        <div><input type="radio" name="${quiz.id}" value="${quiz.answer_one}" required>
                            <label>${quiz.answer_one}</label></div>
                        <div><input type="radio" name="${quiz.id}" value="${quiz.answer_two}" required>
                            <label>${quiz.answer_two}</label></div>
                        <div><input type="radio" name="${quiz.id}" value="${quiz.answer_three}" required>
                            <label>${quiz.answer_three}</label></div>
                        <div><input type="radio" name="${quiz.id}" value="${quiz.answer_four}" required>
                            <label>${quiz.answer_four}</label></div>
                    </div>
                    </c:if>
                    <c:if test="${score>0}">
                        <p>Answer => <i class="text-success">${quiz.correct_answer}</i></p>
                    </c:if>
                </div>
                </c:forEach>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
        <c:if test="${score>0}">
            <div class="mt-5 d-flex justify-content-center">
                <a href="quiz?name=${name}" class="btn btn-danger">RESET </a>
            </div>
        </c:if>
    </div>
</div>
<c:remove var="score" scope="session"/>
<%@include file="templates/footer.jsp" %>
