<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

<div class="container">
    <h1>Enter Details</h1>

<form action="/submit-form" method="POST">
  <label for="city">City:</label>
  <input type="text" id="city" name="city" value="Krakow"><br><br>

  <label for="pricemin">Minimum Price:</label>
  <input type="text" id="pricemin" name="pricemin" value="1000"><br><br>

  <label for="pricemax">Maximum Price:</label>
  <input type="text" id="pricemax" name="pricemax" value="500000"><br><br>

  <label for="area_min">Minimum Area:</label>
  <input type="text" id="area_min" name="area_min" value="40"><br><br>

  <label for="area_max">Maximum Area:</label>
  <input type="text" id="area_max" name="area_max" value="500"><br><br>

  <label for="pages">Number of Pages:</label>
  <input type="number" id="pages" name="pages" min="1" value="4"><br><br>

  <input type="submit" value="Scrap">
</form>







</div>


<%@include file="common/footer.jspf"%>

<script type="text/javascript">
            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd'
            });
        </script>