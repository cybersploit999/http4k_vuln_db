package org.http4k.routing.websocket

import org.http4k.core.Method
import org.http4k.core.UriTemplate
import org.http4k.routing.RoutingWsHandler
import org.http4k.routing.TemplatedWsRoute
import org.http4k.routing.WsPathMethod
import org.http4k.websocket.WsHandler

infix fun String.bind(method: Method) = WsPathMethod(this, method)
infix fun String.bind(handler: RoutingWsHandler) = handler.withBasePath(this)
infix fun String.bind(action: WsHandler) =
    RoutingWsHandler(listOf(TemplatedWsRoute(UriTemplate.from(this), action)))

