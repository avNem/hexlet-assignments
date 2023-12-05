@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
<head>
    <title>UsersList</title>
</head>
<body>
<h1>UsersList</h1>
@if(page.getUsers().isEmpty())
    <p>No anymore</p>
@else
    @for(var user : page.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getFirstName()}</a></h2>
            <p>${user.getLastName()} ${user.getEmail()}</p>
        </div>
    @endfor
@endif
</body>
</html>
