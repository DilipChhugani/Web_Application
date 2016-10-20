<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<body>
	<div class="container">
		<section id="content">
			<form action="AdminInsert" method="post">
				<h1>Enter Book Details</h1>
				<div>
					<input type="text" placeholder="Book Id" required="" name="bookid" />
				</div>
				<div>
					<input type="text" placeholder="Book Title" required=""
						name="booktitle" />
				</div>
					<div>
					<input type="text" placeholder="Description" required=""
						name="description" />
				</div>
				<div>
					<input type="text" placeholder="Book Author" required=""
						name="authorname" />
				</div>
					
				<div>
					<input type="submit" value="Insert" /> 
				</div>
			</form>
			<!-- form -->

		</section>
		<!-- content -->
	</div>
	<!-- container -->
</body>

</body>
</html>