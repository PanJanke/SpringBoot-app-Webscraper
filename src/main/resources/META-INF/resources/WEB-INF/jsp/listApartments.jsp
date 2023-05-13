

<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>



<div class="container">
    <h1>Your Apartments</h1>
    <table class="table">
        <thead>
            <tr>
                <th>webAddress</th>
                <th>address</th>
                <th>price</th>
                <th>pricePerSquareMeter</th>
                <th>numOfRooms</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${apartments}" var="apart">
                <tr>
                    <td><a href=${apart.webAddress}>link</a></td>
                    <td>${apart.address}</td>
                    <td>${apart.price}</td>
                    <td>${apart.pricePerSquareMeter}</td>
                    <td>${apart.numOfRooms}</td>
                    <td> <a href="delete-apart?id=${apart.id}" class="btn btn-warning">Observe</a>   </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

<%@include file="common/footer.jspf"%>