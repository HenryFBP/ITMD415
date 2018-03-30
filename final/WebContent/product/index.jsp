<%@page import="java.util.ArrayList"%>
<%@page import="Final.Product.ProductHandler"%>
<%@page import="Final.*"%>
<%@page import="Final.Product.*"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashMap"%>
<%
    ProductHandler ph = new ProductHandler();
    ArrayList<Product> allproducts = new ArrayList<>();

    HashMap<Class, ArrayList<Product>> productsMap = new HashMap<>();

    try
    {
        allproducts = ph.read(Lib.getCustomer(request));
        productsMap = ProductHandler.sortProductsByClass(allproducts);
    }
    catch(CustomerNotLoggedInException e)
    {

    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" href="/final/css/screen.css" />
</head>
<body>
  <nav><jsp:include page="/navbar.jsp"></jsp:include></nav>
  <aside>
    <a><%=CustomerControllerServlet.generateStatus(session)%></a>
  </aside>
  <main>
  <section>
    <h1>Your products:</h1>
    <ul>
      <%=ProductHandler.ProductHashMapToHTML(productsMap)%>
    </ul>
  </section>
  <section>
    <header>
      <h1>New Product</h1>
    </header>
    <p>You can record either a Car, or a Part.</p>
    <ul>
      <li><a href="newcar.jsp">Car</a></li>
      <li><a href="newpart.jsp">Part</a></li>
    </ul>
  </section>
  </main>
</body>
</html>