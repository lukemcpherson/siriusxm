package com.siriusxm.example

case class Cart(products: List[Product]) {

  final val TAX_RATE = 0.125
  def addProducts(newProducts: List[Product]): Cart = Cart(products ++ newProducts)

  def addProductsByQuantity(product: Product, quantity: Int): Cart = addProducts(List.fill(quantity)(product))

  // setScale = set precision; BigDecimal.ROUND_HALF_UP (rounds up to nearest, most precise place)
  // NOTE: Precision NOT required on additive operations since there's no way to add precision from these operations
  def subtotalPreTax: BigDecimal = products.foldRight(BigDecimal(0.00))(_.price + _)

  def tax: BigDecimal = (subtotalPreTax * TAX_RATE).setScale(2, BigDecimal.RoundingMode.HALF_UP)

  def subtotalWithTax: BigDecimal = subtotalPreTax + tax
}

object Cart
