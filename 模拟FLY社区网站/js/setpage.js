window.onload=function(){
				var oDiv1=document.getElementById('myMessage');
				var oDiv2=document.getElementById('photo');
				var oDiv3=document.getElementById('password');
				var d1=document.getElementById('data1');
				var d2=document.getElementById('data2');
				var d3=document.getElementById('data3');
				oDiv2.style.display='none';
				oDiv3.style.display='none';
				d1.onclick=function(){
					
					oDiv2.style.display='none';
					d2.style.borderBottom='none';
					d2.style.color='black';
					
				    oDiv3.style.display='none';
				    d3.style.borderBottom='none';
				    d3.style.color='black';
				    
					oDiv1.style.display='block';
					this.style.borderBottom=3+'px '+'solid #009688 ';
					this.style.color='#009688';
				}
				d2.onclick=function(){
					
					oDiv1.style.display='none';
					d1.style.borderBottom='none';
					d1.style.color='black';
					
				    oDiv3.style.display='none';
				    d3.style.borderBottom='none';
				    d3.style.color='black';
				    
					oDiv2.style.display='block';
					this.style.borderBottom=3+'px '+'solid #009688 ';
					this.style.color='#009688';
				}
				d3.onclick=function(){
					
					oDiv1.style.display='none';
					d1.style.borderBottom='none';
					d1.style.color='black';
					oDiv2.style.display='none';
					d2.style.borderBottom='none';
					d2.style.color='black';
					oDiv3.style.display='block';
					this.style.borderBottom=3+'px '+'solid #009688 ';
					this.style.color='#009688';
				}
			}