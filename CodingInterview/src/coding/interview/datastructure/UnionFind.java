package coding.interview.datastructure;

import java.util.Arrays;

import static java.lang.System.*;

public class UnionFind {

    int[] id;
    int[] sz;

    int count;

    public UnionFind(int n){
        id = new int[n];
        sz = new int[n];
        count = n;

        for(int i=0;i<id.length;i++){
            id[i] = i;
        }
        Arrays.fill(sz, 1);
    }

    public int find(int p){
        if(p >= this.id.length){
            return -1;
        }
        while(this.id[p] != p){
            p = this.id[p];
        }

        return p;
    }

    public void union(int p, int q){
        if(this.id[p] == this.id[q]){
            return ;
        }

        int pRoot = find(p);
        int qRoot = find(q);

        if(this.sz[pRoot] >= this.sz[qRoot]){
            this.id[qRoot] = pRoot;
            this.sz[pRoot] += this.sz[qRoot];
        }else {
            this.id[pRoot] = qRoot;
            this.sz[qRoot] += this.sz[pRoot];
        }
        count--;

    }

    public boolean connected(int p, int q){

        return find(p) == find(q);

    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        for(int i=1;i<10;i++){
            if(Math.random() > 0.5) {
                uf.union(0, i);
            }
        }

        out.println(uf.getCount());

    }


}
