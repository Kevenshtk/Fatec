<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nome = $_POST['nome'];
    $email = $_POST['email'];

    $to = 'kevendicamargo@gmail.com';
    $subject = 'Nova inscrição para o evento de games';
    $message = "Nome: $nome\n";
    $message .= "Email: $email\n";

    mail($to, $subject, $message);

    header('Location: index.html');
} else {
    header('Location: index.html');
}
?>
