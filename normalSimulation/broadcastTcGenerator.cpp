#include <iostream>
using namespace std;

int main(){
    int numOfProcessors; cin>>numOfProcessors;
    cout<<numOfProcessors<<endl;

    for(int pr=0;pr<numOfProcessors;pr++){
        cout<<2<<endl;
        cout<<pr<<endl;
        cout<<"message-"<<(pr*100)<<endl;

        // exit condition
        if(pr!=numOfProcessors-1){
            cout<<1000<<endl;
        } else {
            cout<<1<<endl;
        }
    }
}