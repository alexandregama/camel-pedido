package br.com.caelum.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() {
				from("file:pedidos?delay=5s").
					log("${id} - ${body}").
				to("file:saida");
			}
		});
		
		context.start();
		Thread.sleep(2_000);
		context.stop();
		System.out.println("Finished work!");
	}	
}
