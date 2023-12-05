@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
    <title>UsersList</title>
</head>
<body>
<h1>User</h1>
        <div>
            <h2>${page.getUser().getId()}</h2>
            <h2>${page.getUser().getEmail()}</h2>
            <h2>${page.getUser().getFirstName()}</h2>
            <h2>${page.getUser().getLastName()}</h2>
        </div>
</body>
</html>
