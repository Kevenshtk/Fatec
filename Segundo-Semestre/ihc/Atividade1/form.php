<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" href="css/estilo.css">
    <link rel="stylesheet" href="css/media.css">
</head>
<body>
    <main>
        <section id="login">
            <div id="imagem">
            </div>
            <div id="form">
                <h1>Login</h1>
                <p>Seja bem-vindo(a) novamente. Faça login para acessar sua conta e poder
                fazer as configurações no seu ambiente.</p>
                <form action="login.php" method="post" autocomplete="on">
                    <div class="campo">
                        <i class="material-icons">person</i>
                        <input type="email" name="login" id="ilogin" required placeholder="Seu e-mail" maxlength="30" autocomplete="email">
                        <label for="iemail">Login</label>
                    </div>
                    <div class="campo">
                        <i class="material-icons">vpn_key</i>
                        <input type="password" name="senha" id="isenha" required minlength="8" maxlength="20" placeholder="Sua senha" autocomplete="current-password">
                        <label for="isenha">Senha</label>
                    </div>
                    <button type="submit">Entrar</button>
                    <a href="#" class="botao">Esqueci a senha <i class="material-icons">mail</i></a>
                </form>
            </div>
        </section>
    </main>
</body>
</html>