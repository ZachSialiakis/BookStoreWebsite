<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Book Store</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<div align="center" style="width: 80%; margin: 0 auto;">
		<h2>New books:</h2>
		<c:forEach items="${listNewBooks}" var="book">
			<div style="display: inline-block; margin: 20px">
				<div>
					<a href="view_book?id=${book.bookId}">
							<img src="data:image/jpg;base64,${book.base64Image}" width="128"
								height="164" />
								</a>
						</div>
						<div>
							<a href="view_book?id=${book.bookId}"> <b>${book.title}</b>
							</a>
						</div>
						<div>Rating *****</div>
						<div>
							<i>by ${book.author}</i>
						</div>
						<div>
							<b>$${book.price}</b>
						</div>
				</div>
		</c:forEach>
	</div>
		<div align="center" style="clear:both">
		<h2>Best-selling Books</h2>
		</div>
		<div align="center" style="clear:both">
		<h2>Most-favoured Books</h2>
		</div>
		<br /><br />
	</div>


	<jsp:directive.include file="footer.jsp" />
</body>
</html>