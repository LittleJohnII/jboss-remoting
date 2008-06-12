package org.jboss.cx.remoting.spi.wrapper;

import java.net.URI;
import java.util.concurrent.ConcurrentMap;
import org.jboss.cx.remoting.Client;
import org.jboss.cx.remoting.ClientSource;
import org.jboss.cx.remoting.Endpoint;
import org.jboss.cx.remoting.RemotingException;
import org.jboss.cx.remoting.RequestListener;
import org.jboss.cx.remoting.Session;
import org.jboss.cx.remoting.SessionListener;
import org.jboss.cx.remoting.spi.Registration;
import org.jboss.cx.remoting.spi.protocol.ProtocolContext;
import org.jboss.cx.remoting.spi.protocol.ProtocolHandler;
import org.jboss.cx.remoting.spi.protocol.ProtocolHandlerFactory;
import org.jboss.cx.remoting.util.AttributeMap;

/**
 *
 */
public class EndpointWrapper implements Endpoint {
    protected final Endpoint delegate;

    protected EndpointWrapper(final Endpoint endpoint) {
        delegate = endpoint;
    }

    public ConcurrentMap<Object, Object> getAttributes() {
        return delegate.getAttributes();
    }

    public Session openSession(final URI remoteUri, final AttributeMap attributeMap, final RequestListener<?, ?> rootListener) throws RemotingException {
        return delegate.openSession(remoteUri, attributeMap, rootListener);
    }

    public ProtocolContext openSession(final ProtocolHandler handler, final RequestListener<?, ?> rootListener) throws RemotingException {
        return delegate.openSession(handler, rootListener);
    }

    public String getName() {
        return delegate.getName();
    }

    public Registration registerProtocol(String scheme, ProtocolHandlerFactory protocolHandlerFactory) throws RemotingException, IllegalArgumentException {
        return delegate.registerProtocol(scheme, protocolHandlerFactory);
    }

    public <I, O> Client<I, O> createClient(final RequestListener<I, O> requestListener) {
        return delegate.createClient(requestListener);
    }

    public <I, O> ClientSource<I, O> createService(final RequestListener<I, O> requestListener) {
        return delegate.createService(requestListener);
    }

    public void addSessionListener(final SessionListener sessionListener) {
        delegate.addSessionListener(sessionListener);
    }

    public void removeSessionListener(final SessionListener sessionListener) {
        delegate.removeSessionListener(sessionListener);
    }
}
