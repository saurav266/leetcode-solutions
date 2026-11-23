class ProductOfNumbers {
    ArrayList<Integer> a;
    public ProductOfNumbers() {
        this.a= new ArrayList<>();
    }
    
    public void add(int num) {
        a.add(num);
    }
    
    public int getProduct(int k) {
        int pro=1;
        for(int i=a.size()-k;i<a.size();i++){
            pro *=a.get(i);
        }
        return pro;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */