package org.example.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     * invoke() recebe o objeto proxy, caso seja necessário distinguir de onde veio a solicitaão.
     *
     * Você executa as operacões que foram interceptadas pelo proxy e depois utiliza
     * Method.invoke() para enviar a request para o objeto real, passando os argumentos necessários.
     *
     * Neste ponto você pode filtrar alguns métodos e deixar outros passar.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);

        if(args != null)
            for(Object arg : args)
                System.out.println(" " + arg);

        return method.invoke(proxied, args);
    }
}

/**
 * To create a dynamic proxy:
 *
 * 1- call the static method Proxy.newProxyInstance() with this arguments.
 *  A- class loader
 *  B- List of interfaces (not classes or abstract classes) you wish the proxy to implement.
 *  C- Implementation of the interface InvocationHandler
 *
 *  O DynamicProxy redirecionará todas as chamadas para o InvocationHandler, portanto,
 *  o construtor do InvocationHandler geralmente recebe a referência ao objeto real para que possa
 *  encaminhar as solicitacões assim que executar sua tarefa intermediária.
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        // Insert a proxy and call again:
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] {Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
