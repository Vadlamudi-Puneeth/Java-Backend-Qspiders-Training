<!DOCTYPE html>
<html>
<head>
<title>Employee Login</title>

<style>

body{
    font-family: Arial;
    background: linear-gradient(135deg,#36d1dc,#5b86e5);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.card{
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0px 10px 25px rgba(0,0,0,0.3);
    width:320px;
}

input{
    width:100%;
    padding:8px;
    margin:10px 0;
}

button{
    width:100%;
    padding:10px;
    background:#5b86e5;
    color:white;
    border:none;
}

</style>

</head>

<body>

<div class="card">

<h2>Employee Login</h2>

<form action="/loginCheck" method="post">

Email:
<input type="email" name="email" required>

Password:
<input type="password" name="password" required>

Role:
<input type="text" name="role" required>

<button type="submit">Login</button>

</form>

</div>

</body>
</html>