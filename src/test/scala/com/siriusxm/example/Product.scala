package com.siriusxm.example

import cats.effect.IO
import org.mockito.Mockito.when
import org.scalatest.funsuite.AnyFunSuite

class ProductTestSuite extends AnyFunSuite {

  test("Getting the price of the product should get the correct price") {
    when(Product.getProductWithPrice("weetabix")).thenReturn(IO(Product("weetabix", 9.98)))
    val productPrice = Product.getProductWithPrice("weetabix")

    assert(productPrice.map(_.price) equals 9.98)
  }

  test("Creating a product with just the title should create a product") {
    when(Product.getProductWithPrice("weetabix")).thenReturn(IO(Product("weetabix", 9.98)))

    val product = Product("weetabix")

    product.map(prdct => assert(prdct equals IO(Product("weetabix", 9.98))))
  }
}