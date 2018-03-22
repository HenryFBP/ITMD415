<%@page import="Final.*"%>
<%@page import="Final.Lib"%>
<%@page import="Final.Customer.*"%>
<%@page import="Final.Customer.Exceptions.*"%>

<%
    Object o = session.getAttribute("customer");

    if (o == null)
    {
        Lib.sendToLogin(response); //send em to login screen if they aren't logged in
        return;
    }

    Customer c = (Customer) o;

    String theirs = request.getParameter("confirm");
    String ours = CustomerControllerServlet.generateDeletionWarning(c);
    ours = Lib.flatten(Lib.unwrap(ours));

    Boolean same = false;

    if (ours.compareTo(theirs) == 0) //they entered the same thing
    {
        same = true;
    }
%>

<a>U WANA DELETE BRO???</a>

<p>You entered: <%=ours %></p>
<p>Prompt: <%=theirs %></p>
<p>
  <%
  if(same)
  {
      out.write("Will delete profile.");
  }
  else
  {
      out.write("You didn't enter the same thing displayed!");
  }
  %>

</p>
