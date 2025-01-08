import os
from colorama import Fore, Back, Style

# VueJS Function
def start_vue(project_path):

    try:
        # Change active directory to Vue project path
        os.chdir(project_path)
        print(Fore.WHITE + f"---> [Change directory to: {project_path}]")

        # Build Vue dist folder (Dev Folder)
        vue_cmd = "npm run build"
        print(Fore.WHITE + f"---> [Executing command: {vue_cmd}]")
        os.system(vue_cmd)

        print(Fore.GREEN + f"[Command Successful]")

    except Exception as e:
        print(Fore.RED + f"[Error:{e}]")

# Refresh NGINX Server
def refresh_nginx():
    try:
        # NGINX restart command
        nginx_cmd = "sudo systemctl restart nginx"
        print(Fore.WHITE + f"---> [Executing command: {nginx_cmd}]")
        os.system(nginx_cmd)

        print(Fore.GREEN + f"[Command Successful]")

    except Exception as e:
        print(Fore.RED + f"[Error:{e}]")

# Main
def main():
    
    vue_project_path = "/home/xyrein/Desktop/SimbankProject/simbank"        # VueJS Project Path
    start_nginx_server = "sudo systemctl start nginx"                       # Command for NGINX

    print(Fore.GREEN + f"[Now executing script]")                           
    print(Fore.GREEN + f"[Starting NGINX Server: {start_nginx_server}]")    # Start NGINX Web Server

    start_vue(vue_project_path)                                             # Start VueJS
    refresh_nginx()                                                         # Refresh NGINX Server

    print(Fore.GREEN + f"[Command executing finished]")
    print(Style.RESET_ALL)

# Call Function
main()


