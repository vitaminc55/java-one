package com.itany.corejava.code11_IO.file;

import java.io.File;

/**
 * @author 石小俊
 * @date 2023年09月01日 9:47
 * 删除指定目录下所有的空目录,包括子目录下的空目录
 */
public class Test07_练习 {

    public static void main(String[] args) throws FileNotExistException {
        remove("E:\\aaa", "E:\\aaa");

    }

    public static void remove(String path, String rootPath) throws FileNotExistException {
        File file = new File(path);

        // 判断传递的参数所指定文件是否存在
        if (!file.exists()) {
            throw new FileNotExistException("该文件不存在");
        }

        // 判断当前文件对象是否表示一个目录
        // 只有是目录时才进行判断,非目录直接无视
        if (file.isDirectory()) {
            // 如果是一个目录,判断是否是空目录
            // 获取该目录中所有的子文件,看是否为空
            // 如果元素数量为0,表示这是一个空目录
            if (file.listFiles().length == 0) {
                String filePath = file.getAbsolutePath();
                String parentPath = file.getParentFile().getAbsolutePath();
                // 如果是一个空目录,则删除当前目录
                file.delete();
                System.out.println("已删除空目录:" + file.getAbsolutePath());
                // 当删除了空目录之后,当前目录本身可能也成为了空目录
                // 这是该目录也需要被删除
                // 因此,需要递归将当前删除的目录的上一级目录进行判断
                // 终止条件:当前目录已经是传递进来的路径的第一层目录了
                // 删除时不能超过指定目录
                // 获取当前目录的地址
                if (!filePath.equals(rootPath)) {
                    remove(parentPath, rootPath);
                } else {
                    return;
                }
            } else {
                // 如果不是一个空目录,获取该目录中所有的子文件进行判断
                File[] files = file.listFiles();
                // 进行递归操作
                for (File f : files) {
                    remove(f.getAbsolutePath(), rootPath);
                }
            }
        }
    }

}
