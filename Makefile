BUILD_DIR=	work
CLONE_DIR=	work/elasticsearch-readonlyrest-plugin
TMP_DIR=	${CLONE_DIR}/tmp
VERSION=	1.14.1_es5.3.0
TAG_NAME=	v${VERSION}
GH_REPO=	https://github.com/sscarduzio/elasticsearch-readonlyrest-plugin


all: dependencies fetch patch build

dependencies:
	sudo pkg install -y openjdk8 bash zip gcc git

fetch:

	@mkdir -p ${BUILD_DIR}
	@(cd ${BUILD_DIR} &&  git clone ${GH_REPO} )
	@(cd ${CLONE_DIR} && git checkout ${TAG_NAME} )

patch:
	@(cd ${CLONE_DIR}  && patch -p0 --suffix orig  < ../../patches/patch-src_main_java_org_elasticsearch_plugin_readonlyrest_acl_ACL.java)

build:

	@(mkdir -p ${TMP_DIR} )
	@(cd ${CLONE_DIR} ; env JAVA_HOME=/usr/local/openjdk8 ./gradlew -q  -g  ${TMP_DIR} --project-cache-dir ${TMP_DIR} --no-daemon assemble -x test )

install:
	@cp ${CLONE_DIR}/build/distributions/readonlyrest-${VERSION}.zip .

clean:
	@rm -rf ${BUILD_DIR}
