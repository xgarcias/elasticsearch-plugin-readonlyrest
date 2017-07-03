--- src/main/java/org/elasticsearch/plugin/readonlyrest/acl/ACL.java.orig       2017-07-03 08:49:11.000000000 +0000
+++ src/main/java/org/elasticsearch/plugin/readonlyrest/acl/ACL.java    2017-07-03 08:49:40.000000000 +0000
@@ -82,7 +82,7 @@
       block -> block.check(rc),
       checkResult -> {
         if (checkResult.isMatch()) {
-          logger.info("request: " + rc + " matched block: " + checkResult);
+          logger.debug("request: " + rc + " matched block: " + checkResult);
           return true;
         }
         else {
@@ -90,7 +90,7 @@
         }
       },
       nothing -> {
-        logger.info(ANSI_RED + " no block has matched, forbidding by default: " + rc + ANSI_RESET);
+        logger.debug(ANSI_RED + " no block has matched, forbidding by default: " + rc + ANSI_RESET);
         return BlockExitResult.noMatch();
       }
     );
