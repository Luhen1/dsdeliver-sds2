import './styles.css';
import { ReactComponent as YouTubeIcon } from "./Youtube.svg";
import { ReactComponent as LinkdinIcon } from "./Linkedin.svg";
import { ReactComponent as InstagramIcon } from "./Instagram.svg";

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.youtube.com/c/DevSuperior" target="_new">
                    <YouTubeIcon/>
                </a>
                <a href="https://www.linkedin.com/school/devsuperior/" target="_new">
                    <LinkdinIcon/>
                </a>
                <a href="https://www.instagram.com/devsuperior.ig/">
                    <InstagramIcon/> 
                </a>
            </div>
        </footer>
    )
}

export default Footer;