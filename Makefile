.PHONY : gen

SRC_DIR=src/main/java/com/telkomdev/protodemo
DST_DIR=src/main/java/com/telkomdev/protodemo

gen:
	protoc -I=$(SRC_DIR) --java_out=$(DST_DIR) $(SRC_DIR)/*.proto