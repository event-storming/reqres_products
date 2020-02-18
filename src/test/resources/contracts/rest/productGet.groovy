package contracts.rest

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url ('/product/1')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
                id: 1,
                name: "TV",
                price: 10000,
                stock: 10,
                imageUrl: "testUrl"
        )
        bodyMatchers {
            jsonPath('$.id', byRegex(nonEmpty()).asLong())
            jsonPath('$.name', byRegex(nonEmpty()).asString())
            jsonPath('$.price', byRegex(nonEmpty()).asLong())
            jsonPath('$.stock', byRegex(nonEmpty()).asLong())
            jsonPath('$.imageUrl', byRegex(nonEmpty()).asString())
        }
        headers {
            contentType(applicationJson())
        }
    }
}
