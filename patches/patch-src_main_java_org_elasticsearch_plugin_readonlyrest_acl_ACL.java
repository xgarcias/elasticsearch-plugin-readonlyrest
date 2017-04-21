--- src/main/java/org/elasticsearch/plugin/readonlyrest/acl/ACL.java.orig       2017-04-18 11:30:52.011996221 +0000
+++ src/main/java/org/elasticsearch/plugin/readonlyrest/acl/ACL.java    2017-04-18 11:31:55.295622221 +0000
@@ -79,14 +79,14 @@
                 block -> block.check(rc),
                 checkResult -> {
                     if (checkResult.isMatch()) {
-                        logger.info("request: " + rc + " matched block: " + checkResult);
+                        logger.debug("request: " + rc + " matched block: " + checkResult);
                         return true;
                     } else {
                         return false;
                     }
                 },
                 nothing -> {
-                    logger.info(ANSI_RED + " no block has matched, forbidding by default: " + rc + ANSI_RESET);
+                    logger.debug(ANSI_RED + " no block has matched, forbidding by default: " + rc + ANSI_RESET);
                     return BlockExitResult.noMatch();
                 });
     }

