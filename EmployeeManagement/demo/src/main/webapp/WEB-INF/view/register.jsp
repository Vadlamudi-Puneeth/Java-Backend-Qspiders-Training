<!DOCTYPE html>
<html>
<head>
<title>Employee Register</title>

<style>

body{
    font-family: Arial;
    background: linear-gradient(135deg,#667eea,#764ba2);
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
    width:350px;
}

h2{
    text-align:center;
}

input{
    width:100%;
    padding:8px;
    margin-top:5px;
    margin-bottom:15px;
}

button{
    width:100%;
    padding:10px;
    background:#667eea;
    color:white;
    border:none;
    cursor:pointer;
}

button:hover{
    background:#5645c0;
}

</style>

</head>

<body>

<div class="card">

<h2>Employee Registration</h2>

<form action="/save" method="post">

Name:
<input type="text" name="name" required>

Salary:
<input type="number" name="salary" required>

Role:
<input type="text" name="role" required>

Email:
<input type="email" name="email" required>

Password:
<input type="password" name="password" required>

<button type="submit">Register</button>

</form>

</div>

</body>
</html>