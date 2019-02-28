/**
 * <h3>Area Client/Server example</h3>
 *
 * ServerApp - gui application that uses {@link learn.ijpds.ch33netw.areaserver.AreaServer}<br>
 * ClientApp - gui app that creates connection to the server<br>
 * The server receives the data, uses it to produce a result, and then sends the result
 * back to the client. The client displays the result.
 * In this example, the data sent from the client comprise the radius of a circle,
 * and the result produces by the server is the area of the circle.
 *
 * <h4>Usage:</h4>
 * Start the server first, then start the client program. In the client program,
 * enter a radius in the text field and press Enter to send the radius to the server.
 * The server computes the area and sends it back to the client.
 */
package learn.ijpds.ch33netw.areaserver;