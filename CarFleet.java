class Solution {
    
    public int carFleet(int target, int[] position, int[] speed) {
        int N =position.length;
        if(N==0)return 0;
        Car[] cars =new Car[N];
        for( int i=0 ;i<N; ++i){
            cars[i] =new Car(position[i], (double)(target- position[i])/speed[i]);
        }
        Arrays.sort(cars,(a,b)->a.position -b.position);
        int ans =0, t =N;
        while(--t >0){
            if(cars[t].time < cars[t-1].time)ans++; //these two cars never form same fleet
            else cars[t-1] =cars[t];
        }
        return ans + 1;
    }
}

class Car {
    int position;
    double time;
    Car(int p, double t){
        position =p;
        time =t;
    }
    
}
