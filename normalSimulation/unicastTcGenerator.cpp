#include <iostream>
using namespace std;

int main(){
    int numOfProcessors; cin>>numOfProcessors;
    cout<<numOfProcessors<<endl;
    
    for(int pr_1=0;pr_1<numOfProcessors;pr_1++){
        for(int pr_2=0;pr_2<numOfProcessors;pr_2++){
            if(pr_1==pr_2)
                continue;
            cout<<1<<endl;
            cout<<pr_1<<endl;
            cout<<pr_2<<endl;
            cout<<"message-"<<(pr_1*pr_2)<<endl;

            // exit condition
            if(pr_1==numOfProcessors-1 && pr_2==numOfProcessors-2){
                cout<<1<<endl;
            } else{
            cout<<1000<<endl;
            }
        }
    }
}