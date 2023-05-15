

<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>



<div class="container">
    <h1>Observed Apartments</h1>
    <table class="table">
        <thead>
            <tr>

                <th>Description</th>
                <th>Target Date</th>
                <th> link </th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>

                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td> <a href="${todo.webAdress}">link</a></td>
                    <td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>   </td>
                    <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>   </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</div>

<%@include file="common/footer.jspf"%>