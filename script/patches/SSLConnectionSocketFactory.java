Index: src/main/java/org/apache/http/conn/ssl/SSLConnectionSocketFactory.java
===================================================================
--- src/main/java/org/apache/http/conn/ssl/SSLConnectionSocketFactory.java	(revision 1764179)
+++ src/main/java/org/apache/http/conn/ssl/SSLConnectionSocketFactory.java	(working copy)
@@ -37,6 +37,8 @@
 import java.util.Arrays;
 import java.util.Collection;
 import java.util.List;
+import java.lang.reflect.InvocationTargetException;
+import java.lang.reflect.Method;
 
 import javax.net.SocketFactory;
 import javax.net.ssl.HostnameVerifier;
@@ -390,6 +392,15 @@
         }
 
         prepareSocket(sslsock);
+
+        try {
+            this.log.debug("Enabling SNI for " + target);
+            Method method = sslsock.getClass().getMethod("setHostname", String.class);
+            method.invoke(sslsock, target);
+        } catch (Exception ex) {
+            this.log.debug("SNI configuration failed");
+        }
+
         this.log.debug("Starting handshake");
         sslsock.startHandshake();
         verifyHostname(sslsock, target);
