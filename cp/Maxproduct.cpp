// #include<bits/stdc++.h>
// #define F(i,l,r)for(i=l;i<=r;i++)
// using namespace std;

// int64_t a[1<<13],b[1<<13],t[1<<15],n,m,p,i,j;

// int main() {
//     cin>>n;
//     F(i,1,n)    cin>>a[i];
//     F(i,1,n)    cin>>b[i] , p=m+=a[i]*b[i];
//     F(i,2,n) F(j,1,i-1) t[i+j]+=(a[i]-a[j])*(b[j]-b[i]) , m=max(m,p+t[i+j]);
//     cout<<m;
// }
#include<bits/stdc++.h>
using namespace std;
#define int long long
const int N=5e3+10;
int a[N],b[N],n;
int t[N*4];
int32_t main(){
	cin>>n;
	int maxi=0;
	for(int i=1;i<=n;i++){
		cin>>a[i];}
	for(int i=1;i<=n;i++){
		 cin>>b[i];
		 maxi+=a[i]*b[i];
	}
	int tp=maxi;
	for(int i=2;i<=n;i++){
		for(int j=1;j<=i-1;j++){
			t[i+j]+=(a[i]-a[j])*b[j]+(a[j]-a[i])*b[i];
			maxi=max(maxi,tp+t[i+j]);
		}
	}
	cout<<maxi<<endl;
	
}