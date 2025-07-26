@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = viewModel() // ← Auto-injects the ViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                viewModel.loginUser(
                    email = email,
                    password = password,
                    onSuccess = { navController.navigate("home") },
                    onFailure = { message -> errorMessage = message }
                )
            }
        ) {
            Text("Login")
        }
    }
}