package com.siriusxm.example

import org.scalatest.funsuite.AnyFunSuite

class CartTestSuite extends AnyFunSuite {

  val emptyCart: Cart = Cart(List.empty)
  val cornflakes: Product = Product("cornflakes", 2.52)
  val weetabix: Product = Product("weetabix", 9.98)

  test("Adding products should, in fact, add products to the cart") {
    assert(emptyCart.products.isEmpty)

    val newCart = emptyCart.addProducts(List(cornflakes, weetabix))

    assert(newCart.equals(Cart(List(cornflakes, weetabix))))
  }

  test("Adding products by quantity should add the specified quantity of products") {
    assert(emptyCart.products.isEmpty)

    val newCart = emptyCart.addProductsByQuantity(cornflakes, 2)

    assert(newCart.equals(Cart(List(cornflakes, cornflakes))))
  }

  test("Calculating the subtotal of the cart pre-tax should return the correct value") {
    val cart = emptyCart.addProductsByQuantity(cornflakes, 2).addProductsByQuantity(weetabix, 1)

    assert(cart.subtotalPreTax equals 15.02)
  }

  test("Calculating the tax of the cart should return the correct tax value") {
    val cart = emptyCart.addProductsByQuantity(cornflakes, 2).addProductsByQuantity(weetabix, 1)

    assert(cart.tax equals 1.88)
  }

  test("Calculating the subtotal with tax should return the correct value") {
    val cart = emptyCart.addProductsByQuantity(cornflakes, 2).addProductsByQuantity(weetabix, 1)

    assert(cart.subtotalWithTax equals (15.02 + 1.88))
  }
}