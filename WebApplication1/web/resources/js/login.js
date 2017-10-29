$('#eye').click
(     
    function()
    {
        $('#eye').toggleClass("glyphicon-eye-close").toggleClass("glyphicon-eye-open");
        togglePassword();
    }
);
function togglePassword()
{
  var password = document.getElementById('password');
  
  if(password.type === "text")
     password.type = "password";   
  else 
      password.type = "text";
  password.focus();
}


