package niu.study.nowcoder;

import java.util.*;

//存储每个学生的基本信息
class Info{
    int index;//录入序号
    String name;//姓名
    int score;//成绩
    //构造方法
    public Info(int index , String name , int score){
        this.index = index;
        this.name = name;
        this.score = score;
    }
}
public class Huawei68{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            List<Info> list = new ArrayList<Info>();//每次输入数据前都要清空
            int stu_num = scan.nextInt();
            int sort_way = scan.nextInt();
            for(int i = 0 ; i < stu_num ; i++){
                String name = scan.nextLine();
                int score = scan.nextInt();
                list.add(new Info(i , name , score));
            }
            //sort_way=0降序排列
            if(sort_way == 0){
                //自定义比较器
                Collections.sort(list ,(o1, o2) ->{
                    if(o1.score != o2.score){
                        return o2.score - o1.score;
                    }else{
                        return o1.index - o2.index;
                    }
                });
            }else{
                //sort_way=1升序排列
                Collections.sort(list , new Comparator<Info>(){
                    public int compare(Info o1, Info o2){
                        if(o1.score != o2.score){
                            return o1.score - o2.score;
                        }else{
                            return o1.index - o2.index;
                        }
                    }
                });
            }
            //打印信息
            for(Info stu : list){
                System.out.println(stu.name + " " + stu.score);
            }
//            list.clear();//清空列表
        }
        scan.close();
    }

}
