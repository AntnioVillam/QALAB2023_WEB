#language: es

Característica: Automatización del proceso de compra en Platanitos
  @Platanitos
  Escenario: Proceso de compra exitoso

    Dado que me encuentro en la página de login de Platanitos
    Cuando inicio sesión con las credenciales correo electronico: "antonio-vm23@hotmail.com" y contraseña: "Ojaso1200"
    Entonces se valida que se muestre el titulo de "Cuenta"
    Y hago clic en la categoria Ofertas
    Y hago clic a un producto que se muestra en Oferta
    Y añado el producto al carrito
    Y hago clic en el carrito
    Entonces se verifica que el producto se haya agregado correctamente al carrito

