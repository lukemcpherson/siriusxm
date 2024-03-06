package com.siriusxm.example

import cats.effect._
import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder
import org.http4s.circe.CirceEntityCodec._
import org.http4s.ember.client.EmberClientBuilder
case class Product(title: String, price: BigDecimal)

object Product {
  implicit val productDecoder: Decoder[Product] = deriveDecoder

  final val PRODUCT_BASEURL = "https://raw.githubusercontent.com/mattjanks16/shopping-cart-test-data/main/"

  def getProductWithPrice(title: String): IO[Product] =  {
    EmberClientBuilder
      .default[IO]
      .build
      .use { client =>
      client
        .expect[Product](Product.PRODUCT_BASEURL + title + ".json")
      }
  }
  def apply(title: String): IO[Product] = {
    getProductWithPrice(title).map { result =>
      Product(title, result.price)
    }
  }
}